package de.mfreund.pamtram.model.generator.provider;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import pamtram.metamodel.ActualSourceSectionAttribute;
import pamtram.metamodel.Attribute;
import pamtram.metamodel.SingleReferenceValueConstraint;
import pamtram.metamodel.TargetSectionAttribute;

/**
 * A simple {@link ITableLabelProvider} that displays names and values of {@link Attribute Attributes}.
 *
 * @author mfreund
 */
public class ResultPageTableViewerLabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {

		// nothing to be done
		//
	}

	@Override
	public void dispose() {

		// nothing to be done
		//
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {

		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {

		// nothing to be done
		//
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {

		// do not use any images
		//
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		if (!(element instanceof Attribute)) {
			return "";
		}

		Attribute<?, ?, ?, ?> att = (Attribute<?, ?, ?, ?>) element;

		switch (columnIndex) {
			case 0:
				return att.getName();
			case 1:
				return this.getValue(att);
			default:
				return "";
		}
	}

	/**
	 * Returns the <em>value</em> to display for the given {@link Attribute} based on its concrete type.
	 *
	 * @param att
	 *            The {@link Attribute}.
	 * @return The value to display.
	 */
	protected String getValue(Attribute<?, ?, ?, ?> att) {

		if (att instanceof ActualSourceSectionAttribute) {
			if (!((ActualSourceSectionAttribute) att).getValueConstraint().isEmpty()
					&& ((ActualSourceSectionAttribute) att).getValueConstraint()
					.get(0) instanceof SingleReferenceValueConstraint) {
				return ((SingleReferenceValueConstraint) ((ActualSourceSectionAttribute) att)
						.getValueConstraint().get(0)).getExpression();
			} else {
				return "";
			}
		} else if (att instanceof TargetSectionAttribute) {
			return ((TargetSectionAttribute) att).getValue();
		} else {
			return "";
		}
	}

}
