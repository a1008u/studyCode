package Kotlin.kotlin_in_action_sample.ch08;

import java.util.ArrayList;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import java.util.List;

/* Java */

public class UsingForEach {
    public static void main(String[] args) {
        List<String> strings = new ArrayList();
        strings.add("42");
        CollectionsKt.forEach(strings, s -> {
           System.out.println(s);
           return Unit.INSTANCE;
        });
    }
}
