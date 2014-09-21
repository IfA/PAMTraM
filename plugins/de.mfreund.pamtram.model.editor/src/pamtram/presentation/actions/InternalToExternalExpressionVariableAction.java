package pamtram.presentation.actions;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.action.Action;

import pamtram.mapping.CalculatorMapping;
import pamtram.mapping.ExpressionVariable;
import pamtram.mapping.ExternalExpressionVariable;
import pamtram.mapping.MappingPackage;

public class InternalToExternalExpressionVariableAction extends Action {
	
	ExpressionVariable oldElement;


	public InternalToExternalExpressionVariableAction(ExpressionVariable m) {
		super("convert to external source element");
		oldElement=m;
	}

	@Override
	public void run() {
		EPackage ePackage = oldElement.eClass().getEPackage();
		ExternalExpressionVariable m=(ExternalExpressionVariable) ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier("ExternalExpressionVariable"));
		
		if(oldElement.getName() != null){
			m.setName(oldElement.getName());
		}
		
		if(oldElement.getSource() != null){
			m.setSource(oldElement.getSource());
		}
		
		
		if(oldElement.getModifier() != null){
			m.eSet(m.eClass().getEStructuralFeature(MappingPackage.EXTERNAL_EXPRESSION_VARIABLE__MODIFIER), oldElement.getModifier());
		}
		
		EObject group=oldElement.eContainer();
		
		List<EObject> objects=new LinkedList<EObject>();
		if(group instanceof CalculatorMapping){
			objects.addAll(((CalculatorMapping) group).getVariables());
			int index=objects.indexOf(oldElement);
			objects.remove(oldElement);
			objects.add(index, m);
			group.eSet(group.eClass().getEStructuralFeature(MappingPackage.CALCULATOR_MAPPING__VARIABLES),objects);
		}
	
	}
	

}
