package study;

import java.util.HashMap;
import java.util.Map;

public class qqq21 {
	// [ 변수 ]
	// 자식 노드 맵
	private Map<Character, qqq21> childNodes = new HashMap<>();
	// 마지막 글자인지 여부
	private boolean isLastChar;

	// [ GETTER / SETTER 메서드 ]
	// 자식 노드 맵 Getter
	Map<Character, qqq21> getChildNodes() {
		return this.childNodes;
	}

	// 마지막 글자인지 여부 Getter
	boolean isLastChar() {
		return this.isLastChar;
	}

	// 마지막 글자인지 여부 Setter
	void setIsLastChar(boolean isLastChar) {
		this.isLastChar = isLastChar;
	}
	public static void main(String[] args) {
		
	}
}

class Trie {
	// [ 변수 ]
	// 루트 노드
	private qqq21 rootNode;

	// [ 생성자 ]
	Trie() {
		rootNode = new qqq21();
	}

	// [ 메서드 ]
	// 자식 노드 추가
	void insert(String word) {
		qqq21 thisNode = this.rootNode;
		for (int i = 0; i < word.length(); i++) {
			thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new qqq21());
		}
		thisNode.setIsLastChar(true);
	}

	// 특정 단어가 들어있는지 확인
	boolean contains(String word) {
		qqq21 thisNode = this.rootNode;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			qqq21 node = thisNode.getChildNodes().get(character);
			if (node == null)
				return false;
			thisNode = node;
		}
		return thisNode.isLastChar();
	}

}