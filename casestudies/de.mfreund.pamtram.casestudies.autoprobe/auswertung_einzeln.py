#!/usr/bin/python
# -*- coding: utf-8 -*-
"""
Created on Wed Jun  4 18:31:49 2014

@author: sascha
"""

import csv
import matplotlib
import sys
matplotlib.use("Qt4Agg")
import pylab as pl
import prettyplotlib as ppl
import numpy as np

excludedNames=[]#"Layer ","UA Items (SigInterface)"]

def readFile(filename):
        """
        Werte einlesen
        """
        vals={}
        histRaw=[]
        with open(filename, "rb") as file:
            f=csv.reader(file, delimiter=',')
            
            for line in f:
                numEls="0"
                mapping=""
                if len(line) != 4:
                    continue;
                for i, val in enumerate(line): 
                    if i== 1:                        
                      mapping=val
                      if mapping in excludedNames:
                          break;
                      elif not vals.has_key(val):
                          vals[val]={}
                    elif i == 2:
                       histRaw.append(float(val))
                       numEls=val
                       if not vals[mapping].has_key(val):
                           vals[mapping][val]=[];
                    elif i == 3:
                        vals[mapping][numEls].append(float(val))
        return (vals, histRaw);

def printFile(fileName):
    values,histRaw=readFile(fileName) 
    fig,ax2=pl.subplots(num=None, figsize=(13, 7), dpi=100, edgecolor='k')
    pl.grid()
    #ppl.hist(ax2,histRaw, bins=40, color=(0.8,0.8,0.8))-> sieht scheiße aus
    hist, bin_edges=np.histogram(histRaw, bins=40)
    bin_edges=bin_edges[0:len(bin_edges)-1]
    step=bin_edges[1]-bin_edges[0]
    histStrings=[]
    for s in hist:
        if s != 0:
            histStrings.append(str(s))
        else :
            histStrings.append("")
    ppl.bar(ax2,bin_edges,hist,width=step, annotate=histStrings,color=(0.8,0.8,0.8))
    ax2.set_xlabel("Anzahl der zugeordneten Elemente in der srcSection")
    ax2.set_ylabel(u"Häufigkeit")

    
 
    ax2.yaxis.set_major_locator(pl.MaxNLocator(35)) 
    pl.tight_layout()


fileName="build.log"
if len(sys.argv) >= 2:
  fileName=sys.argv[1]
  argv=sys.argv
  argv.pop(0)
  for f in argv:
      printFile(f)
  pl.show()
else:
    printFile(fileName)
pl.show()


