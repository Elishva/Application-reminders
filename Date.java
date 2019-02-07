/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmn14_b;

/**
 *
 * @author avis
 */
public class Date {
  
    private int  _day;
    private int _month;
    private int _year;
    
   public Date()
   {
      _day=1;
      _month=1;
      _year=2018;
   }
    
    public Date(int day,int month,int year)
    {
       setDay(day);
       setMonth(month);
       _year=year;
    }
    
    //get year
    public int getYear()
    {
       return _year; 
    }
    
    //get day
    public int getDay()
    {
       return _day; 
    }
    
    //get month
    public int getMonth()
    {
       return _month; 
    }
    
    //set year
    public void setYear( int year)
    {
         
       _year=year; 
    }
    //set day
    public void setDay( int d)
    {
       if(d>0&& d<31)
        _day=d; 
    }
    //set month
    public void setMonth( int m)
    {
        if(m >0 && m <13)
            _month=m; 
    }
    
    
     public boolean equals (Object d)
	{   
                Date date=(Date)d;
		if(getDay()==date.getDay() && getMonth()==date.getMonth() && getYear()== date.getYear() )
			return true;
		else
			return false;
	}
        
        
         //Override hashCode
    public int hashCode() 
    {
        int dayPerMonth=31;
        int dayYear =dayPerMonth*12;
        int hash =_year*dayYear+dayPerMonth*_month+_day;
     
        return hash;
    }
}
