package org.anhcraft.spaciouslib.mojang;

import org.anhcraft.spaciouslib.annotations.DataField;
import org.anhcraft.spaciouslib.annotations.Serializable;
import org.anhcraft.spaciouslib.builders.EqualsBuilder;
import org.anhcraft.spaciouslib.builders.HashCodeBuilder;

/**
 * Represents a player skin implementation.
 */
@Serializable
public class Skin {
    // https://mineskin.org/218314
    public static final Skin STEVE = new Skin("eyJ0aW1lc3RhbXAiOjE1MjczNTE4NzU2MzYsInByb2ZpbGVJZCI6Ijg2NjdiYTcxYjg1YTQwMDRhZjU0NDU3YTk3MzRlZWQ3IiwicHJvZmlsZU5hbWUiOiJTdGV2ZSIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGMxYzc3Y2U4ZTU0OTI1YWI1ODEyNTQ0NmVjNTNiMGNkZDNkMGNhM2RiMjczZWI5MDhkNTQ4Mjc4N2VmNDAxNiJ9LCJDQVBFIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjc2N2Q0ODMyNWVhNTMyNDU2MTQwNmI4YzgyYWJiZDRlMjc1NWYxMTE1M2NkODVhYjA1NDVjYzIifX19", "f/C13ic+nVc/TWHQoKFNu9481+YMm0e/l8krgnSpUCPktmUaFHEiwz4F1w8YJaivX1V72OhO65ylFbTk7LuX+SqWj4Ba87mzmdVILA9gZifmKS80dYKvor8pE5sGYl1DdL8ipvXN6HzFbXyDVTG3Cey5es5z4vtLxRYSB0PPl2DGYqXjjvIuxmLiOugpSOmgQskdUeDolC6HZFgl7ZlFnpxaqkD96eHtZx4LA0M1kj0bhBXLmZoL8RynIttfQVdcH4oQL5MJoHzzDov1hqYbB/3I/0Tc+QFhIKSE1KiHC0kJko/sdjgKPJRpwstM/zzDTcdAwz5P1fO26LLVuY1dSQDwtZbB6rDc1TUU6VcmVw1Ly2gnalimxA8QHwyTLxtafKDhyHU4/jxgj2FnicS7KpGtsQERzLqempJotF6x8UyQN/i/lHHe2JpamV1lva4LesOL01YSv8UQY0K7Y6V8mK6gi4ZtQh1isM9O/bamxyBkIho+gqMTidXfVBaG/JtuxAsqOEZFER4UbwjnGaqcPhJtC3MkseRQe7W9w7JxA1F1UD7S3jyEkT6zdBX4EJLl8fVa7HJyPlIU8QYAAUs0P2Qw3aVEFY3aCdFlYlL63H0izVe0wF4snvH0qImW5MF8UjrzUbY4Fw4glX25tR1Orb6h5bitS8mW9By2o5KAHLY=");
    // https://mineskin.org/396213
    public static final Skin ALEX = new Skin("eyJ0aW1lc3RhbXAiOjE1NDAwODc3MDUyNzYsInByb2ZpbGVJZCI6IjZhYjQzMTc4ODlmZDQ5MDU5N2Y2MGY2N2Q5ZDc2ZmQ5IiwicHJvZmlsZU5hbWUiOiJNSEZfQWxleCIsInNpZ25hdHVyZVJlcXVpcmVkIjp0cnVlLCJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODNjZWU1Y2E2YWZjZGIxNzEyODVhYTAwZTgwNDljMjk3YjJkYmViYTBlZmI4ZmY5NzBhNTY3N2ExYjY0NDAzMiIsIm1ldGFkYXRhIjp7Im1vZGVsIjoic2xpbSJ9fX19", "k62gX82u1JBsUMXPAzADWTlpzrBNti01wwnJ+l9TnNP7PuZ7dvlHztAsIr3H4EdBWmyjq3lpdWRgRkuQ0BiFai/cNuqTJBRJENIXH0pdNQnLBkyJmGsFAYHrufEtUr0ikSF2afjAY65wH6v3iCiMofnEXuzB/xrhjIlGl83LCeTLSWJ36d321XCiP2hJ/LF9a6UY7x4Po2qSzFyC5naqm84+BaTzRlnhX5spJjkexJ5N9APhcmzzALybwEfCXmeRMct+8s8qTdmHPm9H8hNg+FxsOekSPgcbZTaLmz8j1tfiX0SBPPhjPNBA604pP53a9ZcOt+6eMJXWy79i9BIlScua4iC5BT7WXitck5h+kNT0mBmMt+YEcbw0VVAVQzE29+MPC+QmrLky1vqZoXb/wsZbnZmbD6npR3b+Fnd0wNW5u83P0ssRUDzqDhPAryPayzDLQ+jLP1GSMA12etFcOE7cFkyv2H1Tz/U9iLJ0kug19dCq6GBB4EkXS51VKbCD23e2gbHwogsW0gzAKiu9d4IcA9lRUB9QMGbHQNzJnD+nU9uxGFryrXx2q0VOcaszmbuC0IKyWSxLtDenO5CBng5Wwlwtmcg9fkqawMhUAuT8+7vyBzV/Oj0gtVCxLEm/cxkXBW6O833p4CmQfXd0Ry2y73GMt2FPHFQgAFS7Q/w=");

    @DataField
    private String value;
    @DataField
    private String signature;

    /**
     * Creates a new Skin instance
     * @param value the value of the skin
     * @param signature the signature of the skin
     */
    public Skin(String value, String signature){
        this.value = value;
        this.signature = signature;
    }

    public String getValue() {
        return value;
    }

    public String getSignature() {
        return signature;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public boolean equals(Object o){
        if(o != null && o.getClass() == this.getClass()){
            Skin s = (Skin) o;
            return new EqualsBuilder()
                    .append(s.signature, this.signature)
                    .append(s.value, this.value)
                    .build();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder(15, 43)
                .append(this.signature)
                .append(this.value).build();
    }
}