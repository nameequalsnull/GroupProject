public abstract class GoodGuy extends Character
{
      private int ap;
      private Weapon weapon;
      private double hchance;
      private double cchance;
      private int toughness;
      private int atkspd;
      
      private static final int DEFAULT_AP = 50;
      private static final double DEFAULT_HIT = .50;
      private static final double DEFAULT_CRIT = .10;
      private static final int DEFAULT_TUFF = 5;
      
      private static final int MAX_AP = 150;
      private static final int MIN_AP_INST = 15;
      private static final double MAX_CHC = 1.0;
      private static final double MIN_CHC = 0.05;
      private static final int MAX_STR = 20;
      private static final int MIN_STR = 1;
      private static final int MIN_SPD = 1;
      private static final int MAX_SPD = 25;
      private static final int MIN_ATK_SPD = 1;
      private static final int MAX_ATK_SPD = 8;
      
      
      public GoodGuy()
      {
         super();
         this.ap = DEFAULT_AP;
         this.atkspd = MIN_ATK_SPD;
         this.hchance = DEFAULT_HIT;
         this.cchance = DEFAULT_CRIT;
         this.toughness = DEFAULT_TUFF;
      }
      
      public GoodGuy(int h, double dc, int a, double hc, double cc, int s, int umin, int umax, String n, String t, int as)
      {
         super(h, dc, umin, umax, n, t);
         this.ap = a;
         this.atkspd = as;
         this.hchance = hc;
         this.cchance = cc;
         this.toughness = s;
      }
      
      public GoodGuy(String n, String t, int h, int a, double hc, double dc, double cc, int s, int umin, int umax, int as)
      {
         super(n, t, h, dc, umin, umax);
            
         if(a < MIN_AP_INST || a > MAX_AP)
         {
            if(a < MIN_AP_INST)
               this.ap = MIN_AP_INST;
            else
               this.ap = DEFAULT_AP;
         }
         else
            this.ap = a;
         
         this.atkspd = as;
            
         this.hchance = (hc - MIN_CHC < 0.0 || MAX_CHC - hc < 0.0) ? (hc -  MIN_CHC < 0.0 ? MIN_CHC : DEFAULT_HIT) : hc;
         this.cchance = (cc - MIN_CHC < 0.0 || MAX_CHC - cc < 0.0) ? (cc -  MIN_CHC < 0.0 ? MIN_CHC : DEFAULT_CRIT) : cc;
         
         setToughness(s);
      }
      
      public void setAP(int a)
      {
         if(a < 0 || a > MAX_AP)
         {
            if(a < 0)
               this.ap = 0;
            else
               this.ap = MAX_AP;
         }
         else
            this.ap = a;
      }
   
   public void setHitChance(double hc)
   {
      this.hchance = (hc < 0.0 || MAX_CHC - hc < 0.0) ? (hc < 0.0 ? 0.0 : MAX_CHC) : hc;
   }
   
   public void setCritChance(double cc)
   {
      this.cchance = (cc < 0.0 || MAX_CHC - cc < 0.0) ? (cc < 0.0 ? 0.0 : MAX_CHC) : cc;
   }
   
   public void setToughness(int s)
   {
      if(s < MIN_STR || s > MAX_STR)
      {
         if(s < MIN_STR && s > 0)
            this.toughness = MIN_STR;
         else if(s < 0)
            this.toughness = 0;
         else
            this.toughness = MAX_STR;
      }
      else
         this.toughness = s;  
   }
   
   public int getAP(){return this.ap;}
   public double getHitChance(){return this.hchance;}
   public double getCritChance(){return this.cchance;}
   public int getToughness(){return this.toughness;}
   
   public Weapon getWeapon(){return this.weapon;}
   public void setWeapon(Weapon w)
   {
      if(w != null)
         this.weapon = w;   
   }
   
   public boolean isArmed(){return this.weapon == null;}
   public void displayInfo()
   {
      System.out.println("NAME: " + this.getName());
      System.out.println("HEALTH: " + this.getHP());
      if(this.isArmed())
         System.out.println("WEAPON: " + this.getWeapon().getType());
      else
         System.out.println("UNARMED");
   }
   public abstract boolean defend();
   public abstract void displayStats();
   
   public abstract void attack(Character opponent);
   
   
}