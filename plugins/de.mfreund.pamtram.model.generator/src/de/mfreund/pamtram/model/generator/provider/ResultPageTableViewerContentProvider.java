package de.mfreund.pamtram.model.generator.provider;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import pamtram.metamodel.Attribute;

public class ResultPageTableViewerContentProvider implements
		IStructuredContentProvider {

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] getElements(Object inputElement) {
		return ((ArrayList<Attribute>) inputElement).toArray();
	}

}
