/*******************************************************************************
 * Copyright (c) 2009-2011 CWI
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:

 *   * Arnold Lankamp - Arnold.Lankamp@cwi.nl
*******************************************************************************/
package org.rascalmpl.parser.gtd.stack;

import org.rascalmpl.parser.gtd.result.AbstractNode;
import org.rascalmpl.parser.gtd.stack.filter.ICompletionFilter;
import org.rascalmpl.parser.gtd.stack.filter.IEnterFilter;

public final class NonTerminalStackNode extends AbstractStackNode{
	private final String expectIdentifier;
	
	public NonTerminalStackNode(int id, int dot, String expectIdentifier){
		super(id, dot);
		
		this.expectIdentifier = expectIdentifier;
	}
	
	public NonTerminalStackNode(int id, int dot, IMatchableStackNode[] followRestrictions, String expectIdentifier){
		super(id, dot, followRestrictions);
		
		this.expectIdentifier = expectIdentifier;
	}
	
	public NonTerminalStackNode(int id, int dot, String expectIdentifier, IEnterFilter[] enterFilters, ICompletionFilter[] completionFilters){
		super(id, dot, enterFilters, completionFilters);
		
		this.expectIdentifier = expectIdentifier;
	}
	
	private NonTerminalStackNode(NonTerminalStackNode original){
		super(original);
		
		expectIdentifier = original.expectIdentifier;
	}
	
	public boolean isEmptyLeafNode(){
		return false;
	}
	
	public String getName(){
		return expectIdentifier;
	}
	
	public AbstractNode match(char[] input, int location){
		throw new UnsupportedOperationException();
	}
	
	public AbstractStackNode getCleanCopy(){
		return new NonTerminalStackNode(this);
	}
	
	public AbstractStackNode getCleanCopyWithResult(AbstractNode result){
		throw new UnsupportedOperationException();
	}
	
	public int getLength(){
		throw new UnsupportedOperationException();
	}
	
	public AbstractStackNode[] getChildren(){
		throw new UnsupportedOperationException();
	}
	
	public boolean canBeEmpty(){
		throw new UnsupportedOperationException();
	}
	
	public AbstractStackNode getEmptyChild(){
		throw new UnsupportedOperationException();
	}
	
	public AbstractNode getResult(){
		throw new UnsupportedOperationException();
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(expectIdentifier);
		sb.append(getId());
		sb.append('(');
		sb.append(startLocation);
		sb.append(')');
		
		return sb.toString();
	}
	
	public boolean isEqual(AbstractStackNode stackNode){
		if(!(stackNode instanceof NonTerminalStackNode)) return false;
		
		NonTerminalStackNode otherNode = (NonTerminalStackNode) stackNode;

		if(!expectIdentifier.equals(otherNode.expectIdentifier)) return false;
		
		return hasEqualFilters(stackNode);
	}
}
