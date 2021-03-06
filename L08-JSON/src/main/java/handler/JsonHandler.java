package handler;

import handler.nodes.AbstractNode;
import handler.nodes.NodeFactory;

public class JsonHandler {

    public static String write(Object object) {
        AbstractNode node = (new NodeFactory(object)).build();
        return node.write();
    }
}
