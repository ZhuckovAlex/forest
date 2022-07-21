package net.magforest.magforest.item.aspect;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class AspectList implements Serializable {
    public LinkedHashMap aspects = new LinkedHashMap();
    public Aspect[] getAspects() {
        Aspect[] q = new Aspect[1];
        return (Aspect[])this.aspects.keySet().toArray(q);
    }
    public int getAmount(Aspect key) {
        return this.aspects.get(key) == null?0:((Integer)this.aspects.get(key)).intValue();
    }
    public AspectList add(AspectList in) {
        Aspect[] arr$ = in.getAspects();
        int len$ = arr$.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Aspect a = arr$[i$];
            this.add(a, in.getAmount(a));
        }

        return this;
    }
    public int size() {
        return this.aspects.size();
    }
    public AspectList add(Aspect aspect, int amount) {
        if(this.aspects.containsKey(aspect)) {
            int oldamount = ((Integer)this.aspects.get(aspect)).intValue();
            amount += oldamount;
        }

        this.aspects.put(aspect, Integer.valueOf(amount));
        return this;
    }
}
