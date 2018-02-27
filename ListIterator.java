class ListIterator{
   
   private Link current;          // current link
   private Link previous;         // previous link
   private LinkList ourList;      // our linked list
   private int nLinks;            //number of links
//--------------------------------------------------------------
   public ListIterator(LinkList list){ // constructor
      
	   ourList = list;
	   reset();
      }
//--------------------------------------------------------------
   public void reset(){            // start at 'first'
            
	   previous = current; 
	   current = ourList.getFirst();
      }
//--------------------------------------------------------------
   public boolean atEnd()         // true if last link
   { return (current.next==null); }
//--------------------------------------------------------------
   public void nextLink(){         // go to next link
          
    	  previous = current;
    	  current = current.next;
      
      }// end of nextLink()
      
//--------------------------------------------------------------
   public Link getCurrent()       // get current link
      { return current; }
//--------------------------------------------------------------
   public void insertAfter(int data){   //inserting a new link
	    
		Link newLink = new Link(data);
	    
		if (current == null){           //if list is empty add link and set first
	        ourList.setFirst(newLink);
	    	newLink.next = newLink;
	        current = newLink;
               } else {
	        newLink.next = current.next;
	        current.next = newLink;
	        }
	        nLinks++;
	
      }// end of insertAfter()   
//--------------------------------------------------------------
   public int deleteCurrent(){    // delete item at current
   
   int value = current.iData;
   
   if(previous == null){        // beginning of list
      
	   ourList.setFirst(current.next);
	   reset();
      }
   else                        // not beginning
      {
		previous.next = current.next;
		if( atEnd() )
		   reset();
		else
		   current = current.next;
       }
   	nLinks--;
   	return value;
   }//end of deleteCurrent()

// -------------------------------------------------------------     
       
   public void createList(int nPeople){
   
				
	   for(int i = nPeople; i > 0; i--){
	   
		   insertAfter(i);   //inserting people into the list
	   }     
		
	}// end of createList()
// -------------------------------------------------------------    
      
   public Link find(int key){      // find link with given key
                                 // (assumes non-empty list)
	   reset();
	   while(current.iData != key){        // while no match,
	   
		   if(key > nLinks)      
			   return null;                 // didn't find it
		   else                           
			   current = current.next;      // go to next link
    	}
    	  return current;                    // found it
    }// end of find()
// -------------------------------------------------------------
   public void WhereIsJosephus(int start, int step){
   
       ourList.setFirst(find(start));   //find link, and set it to first
       
       if(ourList.getFirst() == null){   //if start is > then people print invalid and return 
    	  
    	JOptionPane.showMessageDialog(null, "Invalid input\nstart is greater then people!");
    	return;
    	}
       reset();                         //reset to first
       boolean flag = true;             //a flag to terminate the while loop
    	  
       while(flag){
       
    	   flag = false;	
    	    
    	   for(int i = 0; i < step; i++){  //stepping through the list
    	   
    		   nextLink();
    	   }
    	  
    	   if(getSize() > 1){    
    	   
    		   deleteCurrent();
    		   flag = true;
    	    }
    	 }
    	    
    	 JOptionPane.showMessageDialog(null,"Josephus is " + current.iData);  //a dialog box prints the output    	    
     }// end of WhereIsJosephus()      
// -------------------------------------------------------------      
   public int getSize(){  //get the number of links in the list
   
	   return nLinks;
   }// end of getSize()
//--------------------------------------------------------------
 }  // end class ListIterator
////////////////////////////////////////////////////////////////
