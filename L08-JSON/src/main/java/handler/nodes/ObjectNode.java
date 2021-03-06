package handler.nodes;

import java.lang.reflect.Field;
import handler.JsonHandler;
import handler.recorder.RecordBuilder;

class ObjectNode extends AbstractNode {

    ObjectNode(Object object) {
        super(object);
    }

    @Override
    public String write() {
        RecordBuilder record = new RecordBuilder();
        record.createObject();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                record.addField(field.getName(), JsonHandler.write(field.get(object)));
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return record.build();
    }

    static boolean isSupported(Object object) {
        return true;
    }
}
