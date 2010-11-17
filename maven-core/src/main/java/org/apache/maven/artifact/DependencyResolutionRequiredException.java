package org.apache.maven.artifact;

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

/**
 * Exception that occurs when an artifact file is used, but has not been resolved.
 *
 * @author <a href="mailto:brett@apache.org">Brett Porter</a>
 * @version $Id: DependencyResolutionRequiredException.java 829934 2009-10-26 20:16:00Z bentmann $
 * @todo it may be better for artifact.getFile() to throw it - perhaps it is a runtime exception?
 */
public class DependencyResolutionRequiredException
    extends Exception
{
    public DependencyResolutionRequiredException( Artifact artifact )
    {
        super( "Attempted to access the artifact " + artifact + "; which has not yet been resolved" );
    }
}