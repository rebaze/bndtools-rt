/*******************************************************************************
 * Copyright (c) 2012 Neil Bartlett.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Neil Bartlett - initial API and implementation
 ******************************************************************************/
package org.bndtools.rt.repository.rest.test;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import org.bndtools.rt.repository.api.QueryCache;
import org.osgi.resource.Capability;
import org.osgi.resource.Requirement;
import org.osgi.service.repository.Repository;

public class MockQueryCache implements QueryCache {
	
	private UUID uuid;
	private Collection<? extends Requirement> requirements;
	
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	@Override
	public UUID createQuery(Collection<? extends Requirement> requirements) throws Exception {
		return uuid;
	}
	
	public void setRequirements(Collection<? extends Requirement> requirements) {
		this.requirements = requirements;
	}

	@Override
	public Collection<? extends Requirement> getQuery(UUID queryId) throws Exception {
		return requirements;
	}

	@Override
	public Map<Requirement, Collection<Capability>> getSolution(UUID queryId, Repository repository) throws Exception {
		return repository.findProviders(requirements);
	}

}
