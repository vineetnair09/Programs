#!/usr/bin/env python2.7
from flask import Flask, request, url_for
import math
import random
import time
#import tkinter
import pandas as pd
import geopy.geocoders as gg
from operator import itemgetter
from collections import Counter

app = Flask(__name__)
app.secret_key = 'This is really unique and secret'

@app.route('/')
def hello_person():
    return """
        <p><h1>Recommending locations and categories relative to business requirements</h1></p><br>
        <p><h2>Select Operation you want:</h2><br><h2>1.Find Appropriate Business for a Location</h2><br><h2>2.Find Appropriate Location for a Business Category</h2><br><h2>Enter 1 OR 2</h2><br></p>
        <form method="POST" action="%s"><input name="operation" /><input type="submit" value="Go!" /></form>
        """ % (url_for('greet'),)

@app.route('/greet', methods=['POST'])
def greet():
    operation=request.form["operation"]
    if operation =="1":
        return """
        <p><h1>Recommending locations and categories relative to business requirements</h1></p><br>
        <p><h2>Enter city and state: </h2></p>
        <form method="POST" action="%s"><input name="input_var" />
        <input type="submit" value="Go!" /></form>
        <p></p>
        """% (url_for('calculate_loc'))
    elif operation == "2":
        return """
        <p><h1>Recommending locations and categories relative to business requirements</h1></p><br>
        <form method="POST" action="%s">
        <p><h2>Enter Business Category: </h2></p>
        <input name="input_var1" />
        <p><h2>Enter Price Range: <br>1.Low <br> 2.Medium <br> 3.High <br> 4.Very High <br> Enter 1 OR 2 OR 3 OR 4: </h2><br></p>
        <input name="input_var2" />
        <input type="submit" value="Go!" /></form>

        """% (url_for('calculate_bus'))

    else:
        return """
        <p><h1>Recommending locations and categories relative to business requirements</h1></p><br>
        <p><h2>Select Operation you want:</h2><br><h2>1.Find Appropriate Business for a Location</h2><br><h2>2.Find Appropriate Location for a Business Category</h2><br><h2>Enter 1 OR 2</h2><br></p>
        <form method="POST" action="%s"><input name="operation" /><input type="submit" value="Go!" /></form>
        """ % (url_for('greet'),)

@app.route('/calculate_loc', methods=['POST'])
def calculate_loc():
    input_var =request.form["input_var"]
    geolocator= gg.GoogleV3()
    geocodes = geolocator.geocode(input_var,exactly_one=False)
    address, (latitude, longitude)=geocodes[0]
    #latitude=float(latitude)
    #longitude=float(longitude)

    """<p>Latitude Longitude</p>
        <p>%s, %s!</p>
        """ % (latitude,longitude)
    dataset = loadCSV("/home/suyog051089/mysite/ind.csv")
    k=3
    mdist=100
    clustering = kmeans(dataset, k, False)
    mincl = 0
    for i in range(k):
        dist=math.sqrt((latitude-clustering["centroids"][i][1])**2+(longitude-clustering["centroids"][i][1])**2)
        if dist<mdist:
            mdist=dist
            mincl=i
    cluster_id = []
    for i in clustering["clusters"][mincl]:
        a,b,c,d,e,f = i
        cluster_id.append(a)

    root1=("/home/suyog051089/mysite/yelp_academic_dataset_business(1).csv")
    dataset = pd.read_csv(root1, sep=',', header=0)
    clusterf = []
    for index,row in dataset.iterrows():
        if row['business_id'] in cluster_id:
            clusterf.append(row)
    c = Counter(i[39] for i in clusterf)

    business_sugg = sorted(c.items(), key=itemgetter(1), reverse=True)
    i=0
    bus=[]
    for b in business_sugg:
        if i>5:
            break
        i+=1
        bus.append(b[0])
    a=bus[0]
    b=bus[1]
    c=bus[2]
    d=bus[3]
    e=bus[4]
    return """
        <p><h1>Recommending locations and categories relative to business requirements</h1></p><br>
        <p><h2>Top 5 Business Categories Suggestion For %s : </p>
        <p>%s</p>
        <p>%s</p>
        <p>%s</p>
        <p>%s</p>
        <p>%s</h2></p>
        """% (input_var,a,b,c,d,e)


@app.route('/calculate_bus', methods=['POST'])
def calculate_bus():
    input_var1 =request.form["input_var1"]
    input_var2 =request.form["input_var2"]
    """<p><h1>Recommending locations and categories relative to business requirements</h1></p><br><p><h2>Business Category Price Range</p><br>
        <p>%s, %s!</h2></p>
        """ % (input_var1,input_var2)
    input_var2 = int(input_var2)
    dataset = loadCSV("/home/suyog051089/mysite/ind.csv")
    k=3
    mdist=100
    clustering = kmeans(dataset, k, True)
    mincl = 0
    for i in range(k):
        dist=math.sqrt((input_var2-clustering["centroids"][i][3])**2)
        if dist<mdist:
            mdist=dist
            mincl=i
    cluster_id = []
    for i in clustering["clusters"][mincl]:
        a,b,c,d,e,f = i
        cluster_id.append(a)
    root1=("/home/suyog051089/mysite/yelp_academic_dataset_business(1).csv")
    dataset = pd.read_csv(root1, sep=',', header=0)
    clusterf = []
    for index,row in dataset.iterrows():
        if row['business_id'] in cluster_id:
            clusterf.append(row)
    countcl = []
    for i in clusterf:
        if input_var1 in i[39]:
            countcl.append(i)
    c = Counter(i[28] for i in countcl)

    loc_sugg = sorted(c.items(), key=itemgetter(1), reverse=True)
    i=0
    loc=[]
    for b in loc_sugg:
        if i>5:
            break
        i+=1
        loc.append(b[0])
    a=loc[0]
    b=loc[1]
    c=loc[2]
    d=loc[3]
    e=loc[4]
    return """
        <p><h1>Recommending locations and categories relative to business requirements</h1></p><br>
        <p><h2>Top 5 Location Suggestion For %s : </p>
        <p>%s</p>
        <p>%s</p>
        <p>%s</p>
        <p>%s</p>
        <p>%s</h2></p>
        """% (input_var1,a,b,c,d,e)

@app.route('/result_bus', methods=['POST'])
def result_bus():
    return 'OK'

def loadCSV(fileName):
    fileHandler = open(fileName, "rt")
    lines = fileHandler.readlines()
    fileHandler.close()
    del lines[0] # remove the header
    dataset = []

    for line in lines:
        instance = lineToTuple(line)
        dataset.append(instance)
    return(dataset)

# Converts a comma separated string into a tuple
def lineToTuple(line):
    # remove leading/trailing witespace and newlines
    cleanLine = line.strip()
    # get rid of quotes
    cleanLine = cleanLine.replace('"', '')
    # separate the fields
    lineList = cleanLine.split(",")
    # convert strings into numbers
    stringsToNumbers(lineList)
    lineTuple = tuple(lineList)
    return lineTuple

# Destructively converts all the string elements representing numbers
# to floating point numbers.
def stringsToNumbers(myList):
    for i in range(len(myList)):
        if (isValidNumberString(myList[i])):
            myList[i] = float(myList[i])

# Checks if a given string can be safely converted into a positive float.
def isValidNumberString(s):
  if len(s) == 0:
    return False
  if  len(s) > 1 and s[0] == "-":
      s = s[1:]
  for c in s:
    if c not in "0123456789.":
      return False
  return True

#calculate euclidean distance
def distance(instance1, instance2):
    if instance1 == None or instance2 == None:
        return float("inf")
    sumOfSquares = 0
    for i in range(1, len(instance1)):
        sumOfSquares += (instance1[i] - instance2[i])**2
    return sumOfSquares

def meanInstance(name, instanceList):
    numInstances = len(instanceList)
    if (numInstances == 0):
        return
    numAttributes = len(instanceList[0])
    means = [name] + [0] * (numAttributes-1)
    for instance in instanceList:
        for i in range(1, numAttributes):
            means[i] += instance[i]
    for i in range(1, numAttributes):
        means[i] /= float(numInstances)
    return tuple(means)

def assign(instance, centroids):
    minDistance = distance(instance, centroids[0])
    minDistanceIndex = 0
    for i in range(1, len(centroids)):
        d = distance(instance, centroids[i])
        if (d < minDistance):
            minDistance = d
            minDistanceIndex = i
    return minDistanceIndex

def createEmptyListOfLists(numSubLists):
    myList = []
    for i in range(numSubLists):
        myList.append([])
    return myList

def assignAll(instances, centroids):
    clusters = createEmptyListOfLists(len(centroids))
    for instance in instances:
        clusterIndex = assign(instance, centroids)
        clusters[clusterIndex].append(instance)
    return clusters

def computeCentroids(clusters):
    centroids = []
    for i in range(len(clusters)):
        name = "centroid" + str(i)
        centroid = meanInstance(name, clusters[i])
        centroids.append(centroid)
    return centroids

def kmeans(instances, k, delays=False, initCentroids=None):
    result = {}
    if (initCentroids == None or len(initCentroids) < k):
        # randomly select k initial centroids
        random.seed(time.time())
        centroids = random.sample(instances, k)
    else:
        centroids = initCentroids
    prevCentroids = []
    clusters = createEmptyListOfLists(k)
    clusters[0] = instances

    if delays:
        delay = 1.0 # seconds
        time.sleep(delay)
    iteration = 0
    while (centroids != prevCentroids):
        iteration += 1
        clusters = assignAll(instances, centroids)
        if delays:
            time.sleep(delay)
        prevCentroids = centroids
        centroids = computeCentroids(clusters)
        withinss = computeWithinss(clusters, centroids)
        result["clusters"] = clusters
    result["centroids"] = centroids
    result["withinss"] = withinss
    return result

def computeWithinss(clusters, centroids):
    result = 0
    for i in range(len(centroids)):
        centroid = centroids[i]
        cluster = clusters[i]
        for instance in cluster:
            result += distance(centroid, instance)
    return result


def extractAttribute(instances, index):
    result = []
    for instance in instances:
        result.append(instance[index])
    return result






