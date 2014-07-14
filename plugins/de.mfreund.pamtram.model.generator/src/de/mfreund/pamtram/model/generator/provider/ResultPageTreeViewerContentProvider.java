package de.mfreund.pamtram.model.generator.provider;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.mfreund.pamtram.model.generator.ClassTreeItem;
import pamtram.metamodel.Class;
import pamtram.metamodel.ContainmentReference;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;

public class ResultPageTreeViewerContentProvider implements ITreeContentProvider {
	
    public void inputChanged(Viewer v, Object oldInput, Object newInput) {
    }

    @Override
    public void dispose() {
    }

	@Override
    public Object[] getElements(Object inputElement) {
    	
    	return (Object[]) inputElement;
    }

    @Override
    public Object[] getChildren(Object parentElement) {
    	ArrayList<Object> ret = new ArrayList<Object>();
    	ClassTreeItem classTreeItem = (ClassTreeItem) parentElement;
    	Reference reference = classTreeItem.getReferenceObject();
    	
    	if(reference != null && reference instanceof NonContainmentReference) {
    		return new Object[]{};
    	}
    	
    	for(Reference ref : classTreeItem.getReferences()) {
    		if(ref instanceof pamtram.metamodel.ContainmentReference) {
    			for(Class c : ((pamtram.metamodel.ContainmentReference) ref).getValue()) {
    				ret.add(ClassTreeItem.createClassTreeItem(c, ref));
    			}
    		} else if(ref instanceof pamtram.metamodel.NonContainmentReference) {
    			for(Class c : ((pamtram.metamodel.NonContainmentReference) ref).getValue()) {
    				ret.add(ClassTreeItem.createClassTreeItem(c, ref));
    			}
    		}
    	}
    	
    	return ret.toArray();
    }

    @Override
    public Object getParent(Object element) {
    	ClassTreeItem classTreeItem = (ClassTreeItem) element;
    	return classTreeItem.getClassObject().eContainer().eContainer();
    }

    @Override
    public boolean hasChildren(Object element) {
    	ClassTreeItem classTreeItem = (ClassTreeItem) element;
    	Reference reference = classTreeItem.getReferenceObject();
    	
    	if(reference != null && reference instanceof NonContainmentReference) {
    		return false;
    	}
    	if(classTreeItem.getReferences() != null) {
    		for(Reference ref : classTreeItem.getReferences()) {
    			if(ref instanceof pamtram.metamodel.ContainmentReference) {
    				if(!(((ContainmentReference) ref).getValue().isEmpty())) {
    					return true;
    				}
    			} else if(ref instanceof pamtram.metamodel.NonContainmentReference) {
    				if(!(((NonContainmentReference) ref).getValue().isEmpty())) {
    					return true;
    				}
    			}
    		}
    		
    	}
    	
    	return false;
    }

}
