package pamtram.converter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import pamtram.mapping.ExpressionVariable;
import pamtram.mapping.ExternalExpressionVariable;
import pamtram.mapping.MappingPackage;
import pamtram.mapping.commands.GenericConvertCommand.IConverter;

public class InternalToExternalExpressionVariableConverter implements
		IConverter<ExpressionVariable, ExternalExpressionVariable> {
	@Override
	public ExternalExpressionVariable convert(
			ExpressionVariable source) {
		
		EPackage ePackage = source.eClass().getEPackage();
		ExternalExpressionVariable target =
				(ExternalExpressionVariable) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ExternalExpressionVariable"));
		
		if(source.getName() != null){
			target.setName(source.getName());
		}
		
		if(source.getSource() != null){
			target.setSource(source.getSource());
		}
		
		
		if(source.getModifier() != null){
			target.eSet(target.eClass().getEStructuralFeature(MappingPackage.EXTERNAL_EXPRESSION_VARIABLE__MODIFIER), source.getModifier());
		}
		
		return target;
	}
}