import java.util.*;

class YoungestCommon {
  public static AncestralTree getYoungestCommonAncestor(
      AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
    // Write your code here.
		int depthOne = getDescendantDepth(descendantOne,topAncestor );
		int depthTwo = getDescendantDepth(descendantTwo,topAncestor);
		if(depthOne > depthTwo){
				return backtrackAncestralTree(descendantOne, descendantTwo, depthOne-depthTwo);
		}
		else
		{
			return backtrackAncestralTree(descendantTwo,descendantOne, depthTwo - depthOne );
		}
  }
	public static AncestralTree backtrackAncestralTree(
		AncestralTree descendantA,AncestralTree descendantB,int diff){
		// move A to same level
			AncestralTree leveringDescendant = moveupsamelevel(descendantA, diff);
		
			
			return thecommonAncestor(leveringDescendant, descendantB);
	}
	public static AncestralTree thecommonAncestor(
				AncestralTree desA, AncestralTree desB ){
			while(desA.name != desB.name){
				desA = desA.ancestor;
				desB = desB.ancestor;
			}
		return desA;
		
	}
	public static AncestralTree moveupsamelevel(AncestralTree descendantA, int diff ){
		while (diff != 0){
			descendantA = descendantA.ancestor;
			diff--;
		}
		return descendantA;
	}
	public static int getDescendantDepth(AncestralTree descendant, AncestralTree topAncestor){
		int depth =0;
		
		while(descendant != topAncestor){
			depth++;
			descendant = descendant.ancestor;
		}
		return depth;
	}

  static class AncestralTree {
    public char name;
    public AncestralTree ancestor;

    AncestralTree(char name) {
      this.name = name;
      this.ancestor = null;
    }

    // This method is for testing only.
    void addAsAncestor(AncestralTree[] descendants) {
      for (AncestralTree descendant : descendants) {
        descendant.ancestor = this;
      }
    }
  }
}
