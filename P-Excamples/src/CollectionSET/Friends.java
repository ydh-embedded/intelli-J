package CollectionSET;

import java.util.HashSet;
import java.util.Set;

public class Friends {
    public static void main(String[] args) {
        mSchnittmenge();
        mMengenAddittion();
        mOnlyFriends();
        mNonCommonFriends();
    }

    public static Set<String> sMyFriends = new HashSet<>(Set.of("alice", "bob", "charlie"));
    public static Set<String> sHisFriends = new HashSet<>(Set.of("bumble", "bee", "charlie"));
    public static Set<String> sCommonFriends;
    public static Set<String> sAllFriends;

    public static void mSchnittmenge(){  // Mengen-Opperation with names (Strings)
        sCommonFriends = new HashSet<>(sMyFriends);
        sCommonFriends.retainAll(sHisFriends);
        System.out.println("Common Friends: " + sCommonFriends);
    }

    public static void mMengenAddittion(){  // Mengen-Opperation with names (as Strings)
        sAllFriends = new HashSet<>(sMyFriends);
        sAllFriends.addAll(sHisFriends);
        System.out.println("All Friends: " + sAllFriends);
    }

    public static void mOnlyFriends(){
        Set<String> sOnlyFriends = new HashSet<>(sMyFriends);
        sOnlyFriends.removeAll(sHisFriends);
        System.out.println("My Friends Only: " + sOnlyFriends);
    }

    public static void mNonCommonFriends(){
        Set<String> sNonCommonFriends = new HashSet<>(sAllFriends);
        sNonCommonFriends.removeAll(sCommonFriends);
        System.out.println("Non-Common Friends: " + sNonCommonFriends);
    }
}