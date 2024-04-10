package CollectionSET;

import java.util.HashSet;
import java.util.Set;

public class friends {
    public static void main(String[] args) {

        mSchnittmenge();
        mMengenAddittion();

    }

    public static void mSchnittmenge(){  // Mengen-Opperation mit namen (Strings)

        Set<String> sMyFriends = new HashSet<>(Set.of("alice", "bob", "charlie"));
        Set<String> sHisFriends = new HashSet<>(Set.of("bumble", "bee", "charlie"));
        Set<String> sCommonFriends = new HashSet<>(sMyFriends);
        sCommonFriends.retainAll(sHisFriends);
        System.out.println(sCommonFriends);
    }

    public static void mMengenAddittion(){  // Mengen-Opperation mit Namen (als Strings)

        Set<String> sMyFriends = new HashSet<>(Set.of("alice", "bob", "charlie"));
        Set<String> sHisFriends = new HashSet<>(Set.of("bumble", "bee", "charlie"));
        Set<String> sAllFriends = new HashSet<>(sMyFriends);
        sAllFriends.addAll(sHisFriends);
        System.out.println(sAllFriends);
    }

    public static void mOnlyFriends(){
        Set<String> sOnlyFriends = new HashSet<>(sMyFriends);
        sOnlyFriends.removeAll(sHisFriends);
        System.out.println(sOnlyFriends);
    }

    public static void mNonCommonFriends(){
        Set<String> sNonCommonFriends = new HashSet<>(sAllFriends);
        sNonCommonFriends.removeAll(sCommonFriends);
        System.out.println(sNonCommonFriends);
    }


    
}

