# SortFiles
The purpose of this project was to build an Integer List ADT to alphabetize lines in a file. 

What each file does:

List.java: Implements a bi-directional queue that contains a “cursor” for iteration. If this ADT has no existing elements, cursor can be undefined/“off the list”. The list has the “front”, “back”, and “cursor” element. 

Lex.java: Takes two command line arguments giving the names of an input file and an output file of any text file. The output file will contain the same lines as the input arranged in alphabetical order. 

ListClient.java: Tests the List ADT operations

We can manipulate our list with the follow operations:

clear()-Sets list to original empty state
moveFront()-place cursor under front element as long as list isn’t empty.

movePrev()- If cursor is defined and not at front, moves cursor one step towards front of list. If the cursor is at the front, make the cursor undefined.

moveNext()-If the cursor exists and is not at the back, move cursor one step towards back of list. If the cursor is at the back of the list, make the cursor undefined.

prepend()-insert a new element into list. If list is non-empty, insert at beginning of list.

append()- insert a new element into list. If non-empty, insert at end of list

insertBefore()- insert element before cursor

insertAfter()- insert element after cursor

deleteFront()- delete the front element

deleteBack()- delete back element

delete()- delete cursor element

toString()- returns String representation of list

copy()- returns new list representing same integer sequence as this list




