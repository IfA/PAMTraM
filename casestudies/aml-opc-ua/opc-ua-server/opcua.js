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