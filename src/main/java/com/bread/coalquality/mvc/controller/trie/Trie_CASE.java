package com.bread.coalquality.mvc.controller.trie;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
public class Trie_CASE {

        public static void main(String[] args) {
            Trie<String, String> trie = new PatriciaTrie<>();
            trie.put("Abigail", "student");
            trie.put("Abi", "doctor");
            trie.put("Annabel", "teacher");
            trie.put("Christina", "student");
            trie.put("Chris", "doctor");
            System.out.println(trie.containsKey("Abigail"));
            System.out.println(trie.prefixMap("Abi").toString());
            System.out.println(trie.prefixMap("Chr").toString());

        }

}
