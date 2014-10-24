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
                      if not vals.has_key(val):
                          vals[val]={}
                    elif i == 2:
                       histRaw.append(float(val))
                       numEls=val
                       if not vals[mapping].has_key(val):
                           vals[mapping][val]=[];
                    elif i == 3:
                        vals[mapping][numEls].append(float(val))
        return (vals, histRaw);
fileName="build.log"
if len(sys.argv) == 2:
  fileName=sys.argv[1]
values,histRaw=readFile(fileName)

fig,ax2=pl.subplots(num=None, figsize=(13, 7), dpi=100, edgecolor='k')
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
#x2.set_ylabel(u"Häufigkeit")
ax2.yaxis.set_visible(False)
ax=ax2.twinx() 
ax.grid(lw=.8)
ax3=ax2.twinx()
ax3.yaxis.tick_left()
ax3.yaxis.set_label_position("left")
#ax3.spines['left'].set_position(('axes', -0.06))

ax3.set_ylabel(u"mittlere Dauer für das Mapping eines Elements in ms/Element")
ax.set_ylabel(u"mittlere Dauer für das Mapping in ms")
ax3.grid(color='b' ,lw=.3)


for key,value in values.iteritems():
    means=[]
    for k,i in value.iteritems():
        means.append({"elements": float(k), "mean": np.median(i)})
    meansSorted=sorted(means, key=lambda e: e["elements"])
    elements=[]
    vals=[]
    for i in meansSorted:
        elements.append(i["elements"])
        vals.append(i["mean"]/1000000.0)
        
    ppl.plot(ax,elements,vals,label=key,  marker='d', markersize=6)
    ppl.plot(ax3,elements,np.array(vals)/np.array(elements),label=key,  marker='x', markersize=6)


ppl.legend(ax, loc='center right', ncol=1)
ax.xaxis.set_major_locator(pl.MaxNLocator(25)) 
ax.yaxis.set_major_locator(pl.MaxNLocator(25)) 
ax2.yaxis.set_major_locator(pl.MaxNLocator(35)) 
ax3.yaxis.set_major_locator(pl.MaxNLocator(25)) 

pl.tight_layout()
pl.show()



