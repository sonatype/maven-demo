package org.apache.maven.repository.legacy.resolver.conflict;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.Collections;

import org.apache.maven.artifact.resolver.ResolutionNode;
import org.apache.maven.repository.legacy.resolver.conflict.OldestConflictResolver;

/**
 * Tests <code>OldestConflictResolver</code>.
 *
 * @author <a href="mailto:markhobson@gmail.com">Mark Hobson</a>
 * @version $Id: OldestConflictResolverTest.java 789077 2009-06-28 09:39:49Z jvanzyl $
 * @see OldestConflictResolver
 */
public class OldestConflictResolverTest
    extends AbstractConflictResolverTest
{
    // constructors -----------------------------------------------------------
    
    public OldestConflictResolverTest()
        throws Exception
    {
        super("oldest");
    }
    
    // tests ------------------------------------------------------------------

    /**
     * Tests that <code>a:1.0</code> wins in the scenario:
     * <pre>
     * a:1.0
     * b:1.0 -> a:2.0
     * </pre>
     */
    public void testDepth()
    {
        ResolutionNode a1n = new ResolutionNode( a1, Collections.EMPTY_LIST );
        ResolutionNode b1n = new ResolutionNode( b1, Collections.EMPTY_LIST );
        ResolutionNode a2n = new ResolutionNode( a2, Collections.EMPTY_LIST, b1n );
        
        assertResolveConflict( a1n, a1n, a2n );
    }

    /**
     * Tests that <code>a:1.0</code> wins in the scenario:
     * <pre>
     * b:1.0 -> a:2.0
     * a:1.0
     * </pre>
     */
    public void testDepthReversed()
    {
        ResolutionNode b1n = new ResolutionNode( b1, Collections.EMPTY_LIST );
        ResolutionNode a2n = new ResolutionNode( a2, Collections.EMPTY_LIST, b1n );
        ResolutionNode a1n = new ResolutionNode( a1, Collections.EMPTY_LIST );
        
        assertResolveConflict( a1n, a2n, a1n );
    }

    /**
     * Tests that <code>a:1.0</code> wins in the scenario:
     * <pre>
     * a:1.0
     * a:2.0
     * </pre>
     */
    public void testEqual()
    {
        ResolutionNode a1n = new ResolutionNode( a1, Collections.EMPTY_LIST );
        ResolutionNode a2n = new ResolutionNode( a2, Collections.EMPTY_LIST );
        
        assertResolveConflict( a1n, a1n, a2n );
    }

    /**
     * Tests that <code>a:1.0</code> wins in the scenario:
     * <pre>
     * a:2.0
     * a:1.0
     * </pre>
     */
    public void testEqualReversed()
    {
        ResolutionNode a2n = new ResolutionNode( a2, Collections.EMPTY_LIST );
        ResolutionNode a1n = new ResolutionNode( a1, Collections.EMPTY_LIST );
        
        assertResolveConflict( a1n, a2n, a1n );
    }
}
