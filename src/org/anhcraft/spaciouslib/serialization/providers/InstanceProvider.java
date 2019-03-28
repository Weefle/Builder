package org.anhcraft.spaciouslib.serialization.providers;

import org.anhcraft.spaciouslib.mojang.Skin;
import org.anhcraft.spaciouslib.serialization.DataSerialization;
import org.anhcraft.spaciouslib.utils.ImmutableTable;
import org.anhcraft.spaciouslib.utils.InitialisationValidator;
import org.anhcraft.spaciouslib.utils.Returner;
import org.anhcraft.spaciouslib.utils.Table;

public class InstanceProvider implements Runnable {
    private static final InitialisationValidator validator = new InitialisationValidator();

    @Override
    public void run() {
        try {
            validator.validate();
        } catch(Exception e) {
            e.printStackTrace();
            return;
        }
        DataSerialization.registerInstanceProvider(Skin.class, new Returner<Skin>() {
            @Override
            public Skin handle() {
                return new Skin(null, null);
            }
        });
        DataSerialization.registerInstanceProvider(Table.class, new Returner<Table>() {
            @Override
            public Table handle() {
                return new Table<>(0, 0);
            }
        });
        DataSerialization.registerInstanceProvider(ImmutableTable.class, new Returner<Table>() {
            @Override
            public ImmutableTable handle() {
                return new ImmutableTable<>(0, 0);
            }
        });
    }
}
