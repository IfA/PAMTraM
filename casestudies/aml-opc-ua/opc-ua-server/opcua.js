/*******************************************************************************
 * Copyright (C) 2018-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
var opcua = require("node-opcua");


var nodeset_amlbasetypes =  "AMLbaseTypesNodeSet.xml";
var nodeset_aml2opcua = 	"../de.mfreund.pamtram.casestudies.aml-opc-ua/Target/AMLUANodeSet.xml";


var server_options = {
   /* [...] */
   nodeset_filename: [
     opcua.standard_nodeset_file,
  	 nodeset_amlbasetypes,
     nodeset_aml2opcua
   ]
};

var server = new opcua.OPCUAServer(server_options);

server.start(function() {
        console.log("Server is now listening ... ( press CTRL+C to stop)");
        console.log("port ", server.endpoints[0].port);
        var endpointUrl = server.endpoints[0].endpointDescriptions()[0].endpointUrl;
        console.log(" the primary server endpoint url is ", endpointUrl );
});