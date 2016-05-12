package de.mfreund.pamtram.model.generator.provider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import pamtram.metamodel.Attribute;
import pamtram.metamodel.SingleReferenceAttributeValueConstraint;
import pamtram.metamodel.SourceSectionAttribute;
import pamtram.metamodel.TargetSectionAttribute;

public class ResultPageTableViewerLabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		Attribute att = (Attribute) element;
		switch (columnIndex) {
		case 0:
			return att.getName();
		case 1:
			if(att instanceof SourceSectionAttribute) {
				if(!((SourceSectionAttribute) att).getValueConstraint().isEmpty() &&
						((SourceSectionAttribute) att).getValueConstraint().get(0) instanceof SingleReferenceAttributeValueConstraint) {
					return ((SingleReferenceAttributeValueConstraint) ((SourceSectionAttribute) att).getValueConstraint().get(0)).getExpression();
				} else {
					return "";
				}
			} else if(att instanceof TargetSectionAttribute) {
				return ((TargetSectionAttribute) att).getValue();
			} else {
				return "";
			}
		default:
			return "";
		}
	}

}
