function DataType(typeString)
{
	this.typeString=typeString;
}

function StructuredType()
{
	this.typeString="Structure";
	this.memberList={};
}

extend(StructuredType, DataType)

function StructuredTypeMember(type, minOccurs, maxOccurs)
{
	this.type=type;
	this.minOccurs=minOccurs;
	this.maxOccurs=maxOccurs;
}

function EnumeratedType(literalList)
{
	this.typeString="Enumeration";
	this.literalList=literalList;
}
1
extend(EnumeratedType, DataType)

/*
 * create typelist
 */
var dataTypeList={};
dataTypeList.Boolean=new DataType("Boolean");
dataTypeList.Integer=new DataType("Integer");
dataTypeList.Rational=new DataType("Rational");
dataTypeList.String=new DataType("String");