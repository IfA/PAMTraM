package de.mfreund.pamtram.model.generator.provider;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import pamtram.metamodel.MetaModelSectionReference;
import pamtram.metamodel.NonContainmentReference;
import pamtram.metamodel.Reference;
import pamtram.metamodel.SourceSectionClass;
import pamtram.metamodel.SourceSectionContainmentReference;
import pamtram.metamodel.TargetSectionClass;
import pamtram.metamodel.TargetSectionContainmentReference;
import pamtram.metamodel.TargetSectionNonContainmentReference;
import de.mfreund.pamtram.model.generator.ClassTreeItem;

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
    		if(ref instanceof pamtram.metamodel.SourceSectionContainmentReference) {
    			for(SourceSectionClass c : ((pamtram.metamodel.SourceSectionContainmentReference) ref).getValue()) {
    				ret.add(ClassTreeItem.createClassTreeItem(c, ref));
    			}
    		} else if(ref instanceof pamtram.metamodel.MetaModelSectionReference) {
    			for(SourceSectionClass c : ((pamtram.metamodel.MetaModelSectionReference) ref).getValue()) {
    				ret.add(ClassTreeItem.createClassTreeItem(c, ref));
    			}
    		}else if(ref instanceof pamtram.metamodel.TargetSectionContainmentReference) {
    			for(TargetSectionClass c : ((pamtram.metamodel.TargetSectionContainmentReference) ref).getValue()) {
    				ret.add(ClassTreeItem.createClassTreeItem(c, ref));
    			}
    		} else if(ref instanceof pamtram.metamodel.TargetSectionNonContainmentReference) {
    			for(TargetSectionClass c : ((pamtram.metamodel.TargetSectionNonContainmentReference) ref).getValue()) {
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
    			if(ref instanceof pamtram.metamodel.SourceSectionContainmentReference) {
    				if(!(((SourceSectionContainmentReference) ref).getValue().isEmpty())) {
    					return true;
    				}
    			} else if(ref instanceof pamtram.metamodel.MetaModelSectionReference) {
    				if(!(((MetaModelSectionReference) ref).getValue().isEmpty())) {
    					return true;
    				}
    			} else  if(ref instanceof pamtram.metamodel.TargetSectionContainmentReference) {
    				if(!(((TargetSectionContainmentReference) ref).getValue().isEmpty())) {
    					return true;
    				}
    			} else if(ref instanceof pamtram.metamodel.TargetSectionNonContainmentReference) {
    				if(!(((TargetSectionNonContainmentReference) ref).getValue().isEmpty())) {
    					return true;
    				}
    			}
    		}
    		
    	}
    	
    	return false;
    }

}
