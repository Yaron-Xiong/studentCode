package com.accompnay.work.J1.work2;

import java.util.*;

/**
 * @author a
 */
public class WordHandler {

	Map<String, Integer> wordMap = new HashMap<>();

	public List<String> handler(List<String> wordList, int k) throws Exception {
		for (String word : wordList) {
			Integer wordNum = wordMap.getOrDefault(word, 0);
			wordMap.put(word, ++wordNum);
		}

		PriorityQueue<String> queue = new PriorityQueue<>(k, (w1, w2) ->
				wordMap.get(w1).equals(wordMap.get(w2)) ?
						w2.compareTo(w1) : wordMap.get(w1) - wordMap.get(w2));

		wordMap.keySet().forEach(word->{
			queue.add(word);
			if (queue.size()>k){
				queue.poll();
			}
		});

		List<String> result = new ArrayList<>();
		while (!queue.isEmpty()){
			result.add(queue.poll());
		}
		Collections.reverse(result);
		return result;
	}
}
