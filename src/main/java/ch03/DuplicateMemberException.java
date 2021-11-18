package ch03;

import javax.management.relation.RelationNotFoundException;

public class DuplicateMemberException extends RuntimeException {
	public DuplicateMemberException(String message) {
		super(message);
	}
}
