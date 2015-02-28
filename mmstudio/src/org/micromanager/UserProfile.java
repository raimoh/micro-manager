///////////////////////////////////////////////////////////////////////////////
//FILE:          UserProfile.java
//PROJECT:       Micro-Manager
//SUBSYSTEM:     
//-----------------------------------------------------------------------------
//
// AUTHOR:       Chris Weisiger, 2015
//
// COPYRIGHT:    University of California, San Francisco, 2015
//
// LICENSE:      This file is distributed under the BSD license.
//               License text is included with the source distribution.
//
//               This file is distributed in the hope that it will be useful,
//               but WITHOUT ANY WARRANTY; without even the implied warranty
//               of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
//
//               IN NO EVENT SHALL THE COPYRIGHT OWNER OR
//               CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
//               INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES.



package org.micromanager;

import java.io.IOException;

/**
 * This interface provides a way to save and recall parameters across multiple
 * sessions of the program. These parameters are specific to the selected user
 * at login time, and thus allow multiple users of a microscope (who all use
 * the same system-level user account) to have different customizations of the
 * program.
 */
public interface UserProfile {
   /**
    * The profile found in this file provide default values for all users;
    * these values will be used only if the user has not set their own values
    * for a key (and such values are often set automatically as a side-effect
    * of interacting with the program).
    */
   public static final String GLOBAL_SETTINGS_FILE = "GlobalUserProfile.txt";

   /**
    * Retrieves a specific value from the parameter storage, as a String.
    * @param c A Class<?> which provides scope for where to look for the key;
    *          this is analogous to the parameter to
    *          java.util.prefs.Preferences.userNodeForPackage(), except that
    *          the scope is specific to the class, not the package the class
    *          is in.
    * @param key The identifier for the parameter.
    * @param fallback Value that will be returned if the key is not found or the 
    *          key points to null.
    * @return The value in storage, or null if the value does not exist.
    */
   public String getString(Class<?> c, String key, String fallback);
   
   /** 
    * Retrieve a specific value from the parameter storage, as a String array. 
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param fallback Value that will be returned if the key is not found or the 
    * key points to null.
    * @return Stored value, or null if the value does not exist
    */
   public String[] getStringArray(Class<?> c, String key, String[] fallback);
   
   /** 
    * Sets a String value in the storage. Changes will not be saved to file 
    * until and unless saveProfile() is called. 
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param value String value to be stored
    */
   public void setString(Class<?> c, String key, String value);
   
   /** 
    * Sets a String Array in the storage. Changes will not be saved to file 
    * until and unless saveProfile() is called. 
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param value String Array to be stored
    */
   public void setStringArray(Class<?> c, String key, String[] value);

   /** 
    * Retrieves a specific value from the parameter storage, as an Integer. 
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param fallback Value that will be returned if the key is not found or the 
    * key points to null. 
    * @return Stored value, or null if the value does not exist
    */
   public Integer getInt(Class<?> c, String key, Integer fallback);
   
   /** 
    * Retrieves a specific value from the parameter storage, as an Arry of 
    * Integers. 
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param fallback Value that will be returned if the key is not found or the 
    * key points to null.
    * @return Stored value, or null if the value does not exist
    */
   public Integer[] getIntArray(Class<?> c, String key, Integer[] fallback);
   
   /** 
    * Sets an Integer in the storage. Changes will not be saved to file 
    * until and unless saveProfile() is called. 
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param value Integer to be stored
    */
   public void setInt(Class<?> c, String key, Integer value);
   
   /** 
    * Sets a new Integer Array in the storage. Changes will not be saved to file 
    * until and unless saveProfile() is called. 
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param value Integer Array to be stored
    */   
   public void setIntArray(Class<?> c, String key, Integer[] value);

   /** 
    * Retrieves a specific value from the parameter storage, as a Double.
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param fallback Value that will be returned if the key is not found or the 
    * key points to null. 
    * @return Stored value, or null if the value does not exist
    */   
   public Double getDouble(Class<?> c, String key, Double fallback);
   
   /** 
    * Retrieves a specific value from the parameter storage, as anArray of 
    * Doubles.
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param fallback Value that will be returned if the key is not found or the 
    * key points to null. 
    * @return Stored value, or null if the value does not exist
    */    
   public Double[] getDoubleArray(Class<?> c, String key, Double[] fallback);
   
   /** 
    * Sets a Double in the storage. Changes will not be saved to file 
    * until and unless saveProfile() is called. 
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param value Double to be stored
    */   
   public void setDouble(Class<?> c, String key, Double value);
   
   /** 
    * Sets a Double Array in the storage. Changes will not be saved to file 
    * until and unless saveProfile() is called. 
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param value Double Array to be stored
    */   
   public void setDoubleArray(Class<?> c, String key, Double[] value);

   /** 
    * Retrieves a specific value from the parameter storage, as a Boolean
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param fallback Value that will be returned if the key is not found or the 
    * key points to null. 
    * @return Stored value, or null if the value does not exist
    */   
   public Boolean getBoolean(Class<?> c, String key, Boolean fallback);
   
   /** 
    * Retrieves a specific value from the parameter storage, as a Boolean Array
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param fallback Value that will be returned if the key is not found or the 
    * key points to null. 
    * @return Stored value, or null if the value does not exist
    */   
   public Boolean[] getBooleanArray(Class<?> c, String key, Boolean[] fallback);
   
   /** 
    * Sets a Boolean value in the storage. Changes will not be saved to file 
    * until and unless saveProfile() is called. 
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param value Boolean to be stored
    */ 
   public void setBoolean(Class<?> c, String key, Boolean value);
   
   /** 
    * Sets a Boolean Array in the storage. Changes will not be saved to file 
    * until and unless saveProfile() is called. 
    * @param c class providing scope for the key
    * @param key  Identifier for the parameter
    * @param value Boolean Array to be stored
    */ 
   public void setBooleanArray(Class<?> c, String key, Boolean[] value);

   /** 
    * Saves the current user's profile. If the program is closed before this
    * method is called, then any changes made since the last call will not
    * be persisted to the next session. This will not include any values     
    * "inherited" from the global defaults.
    * Generates the same output as saveProfileToFile(), but the file i
    * automatically selected (stored in an OS-appropriate location for user
    * data).     
    * @throws IOException if the file cannot be written for any reason.
    */
   public void saveProfile() throws IOException;

   /** 
    * Saves the current user's profile to the specified file. This will not
    * include any "inherited" values from the global defaults.
    * @param path file path for user profile file
    * @throws IOException if the file cannot be written for any reason.
    */
   public void saveProfileToFile(String path) throws IOException;

   /** 
    * Saves the current user's profile to the specified file. This will not
    * include any "inherited" values from the global defaults, and only keys 
    * that are specific to the provided class are preserved. 
    * This can be useful if you want to be able to save/load your
    * settings, in conjunction with appendFile(), below. 
    * @param c only setting belonging to this class will be saved
    * @param path file path where the data will be saved
    * @throws java.io.IOException
    */
   public void saveProfileSubsetToFile(Class<?> c, String path) throws IOException;

   /** 
    * Remove all keys from the profile that are associated with the provided
    * class. This functionally allows you to reset the profile to use the
    * default values (or the values specified in the global settings file).
    * Changes will not be saved until and unless saveProfile() is called.
    * @param c Key-values belonging to this class will be removed
    */
   public void clearProfileSubset(Class<?> c);

   /** 
    * Merge the profile at the specified path into the current active user
    * profile. All keys specified in the file will overwrite keys in the
    * active profile.
    * @param path file to which the profile should be appended
    */
   public void appendFile(String path);
}
