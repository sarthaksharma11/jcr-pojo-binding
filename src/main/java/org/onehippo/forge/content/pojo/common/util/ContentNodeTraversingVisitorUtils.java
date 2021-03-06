/**
 * Copyright 2015-2015 Hippo B.V. (http://www.onehippo.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onehippo.forge.content.pojo.common.util;

import org.onehippo.forge.content.pojo.model.ContentNode;

/**
 * {@link ContentNode} traversing utilities.
 */
public class ContentNodeTraversingVisitorUtils {

    private ContentNodeTraversingVisitorUtils() {
    }

    /**
     * Traverse the {@code contentNode} with the {@code visitor}.
     * @param contentNode content node
     * @param visitor traversing visitor instance
     */
    public static void traverse(final ContentNode contentNode, ContentNodeTraversingVisitor visitor) {
        if (visitor.isAcceptable(contentNode)) {
            visitor.accept(contentNode);
        }

        if (visitor.isDownTraversable(contentNode)) {
            for (ContentNode childContentNode : contentNode.getNodes()) {
                traverse(childContentNode, visitor);
            }
        }
    }
}
