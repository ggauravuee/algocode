package com.leetcode.problem.logic.medium;

import java.util.*;

public class GroupGivenTheGroupSize
{
  public List<List<Integer>> groupThePeople(int[] groupSizes) {

    /*
    Input: groupSizes = [3,3,3,3,3,1,3]
    Output: [[5],[0,1,2],[3,4,6]]
    */

    /*
    Input: groupSizes = [2,1,3,3,3,2]
    Output: [[1],[0,5],[2,3,4]]
    */

    List<List<Integer>> peopleGroups = new ArrayList<>();
    Map<Integer, List<Integer>> groupIDToIndexMapping = new HashMap<>();
    Set<Integer> groupIDKeys = groupIDToIndexMapping.keySet();

    for(int i=0 ; i < groupSizes.length; i++)
    {
      int groupId = groupSizes[i];
      if (groupIDKeys.contains(groupId))
      {
        List<Integer> gpList = groupIDToIndexMapping.get(groupId);
        if (gpList.size() < groupId)
        {
          gpList.add(i);
        }else
        {
          peopleGroups.add(groupIDToIndexMapping.remove(groupId));

          List<Integer> groups = new ArrayList<>();
          groups.add(i);
          groupIDToIndexMapping.put(groupId, groups);
        }

      }else {
        List<Integer> groups = new ArrayList<>();
        groups.add(i);
        groupIDToIndexMapping.put(groupId, groups);
      }
    }

    groupIDToIndexMapping.forEach((integer, integers) ->
    {
      peopleGroups.add(integers);
    });

    return peopleGroups;

  }

}
