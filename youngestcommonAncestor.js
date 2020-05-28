// This is an input class. Do not edit.
class AncestralTree {
  constructor(name) {
    this.name = name;
    this.ancestor = null;
  }
}

function getYoungestCommonAncestor(topAncestor, descendantOne, descendantTwo) {
  // Write your code here.
	  const	depthOne = getdepth(topAncestor, descendantOne);
		const depthTwo = getdepth(topAncestor, descendantTwo);
		if(depthOne> depthTwo){
			return backtrackingAncestor(descendantOne,descendantTwo, depthOne-depthTwo );
		}else
			{
				return backtrackingAncestor(descendantTwo,descendantOne, depthTwo-depthOne);
			}
}
function backtrackingAncestor(descendantOne, descendantTwo, diff){
	while(diff > 0){
		descendantOne = descendantOne.ancestor;
		diff--;
	}
	while(descendantOne != descendantTwo){
		descendantOne = descendantOne.ancestor;
		descendantTwo= descendantTwo.ancestor;
	}
	return descendantOne;
}
function getdepth(topAncestor, descendant){
	let depth=0;
	while (descendant !==topAncestor ){
		descendant= descendant.ancestor;
		depth++;
	}
	return depth;
}

// Do not edit the line below.
exports.AncestralTree = AncestralTree;
exports.getYoungestCommonAncestor = getYoungestCommonAncestor;
