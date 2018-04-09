/*******************************************************************************
 * Copyright (C) 2014-2018 Matthias Freund and others, Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.mfreund.gentrans.transformation.registries;

import java.util.LinkedHashMap;

import de.mfreund.gentrans.transformation.descriptors.EObjectWrapper;
import de.mfreund.gentrans.transformation.library.LibraryEntryInstantiator;

/**
 * This class represents a registry that relates temporarily created elements for LibraryEntries (represented by an
 * {@link EObjectWrapper}) to their {@link LibraryEntryInstantiator}.
 *
 * @author mfreund
 */
public class LibraryEntryRegistry extends LinkedHashMap<EObjectWrapper, LibraryEntryInstantiator> {

	/**
	 *
	 */
	private static final long serialVersionUID = 4618325882304536562L;

}
