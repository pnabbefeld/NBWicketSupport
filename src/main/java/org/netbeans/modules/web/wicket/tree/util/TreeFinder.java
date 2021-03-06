/*
 * Not ready for public use, so <b>don't use it</b>, yet.
 */
package org.netbeans.modules.web.wicket.tree.util;

import com.sun.source.tree.Tree;
import com.sun.source.util.TreeScanner;

/**
 *
 * @author Tim Boudreau
 */
public class TreeFinder extends TreeScanner<Void, Void> {

    private final Tree lookFor;
    private boolean found = false;

    TreeFinder(Tree lookFor) {
        this.lookFor = lookFor;
    }

    boolean success() {
        return this.found;
    }

    @Override
    public Void scan(Tree arg0, Void arg1) {
        this.found |= this.lookFor.equals(arg0);
        if (this.found) {
            return null;
        }
        return (Void)super.scan(arg0, arg1);
    }
}
