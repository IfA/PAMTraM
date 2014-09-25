#!/usr/local/bin/node
var exec = require('child_process').exec;
var connect = require('connect');
var serveStatic = require('serve-static');
connect().use(serveStatic("/home/sascha/workspace2/test/out/html/")).listen(8001);
exec('/home/sascha/Dokumente/ComicViewer/webViewBuild/webviewer http://localhost:8001/movisa.html',
 function callback(error, stdout, stderr){
    process.exit(0);}
);