/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.List;
public class ObjectUtils {
	public static boolean isNullOrEmpty(Object obj){
		if(obj == null){
			return true;
		}else if(obj instanceof String && ((String) obj).trim().isEmpty()){
			return true;
		}else if(obj instanceof List && ((List) obj).isEmpty()){
			return true;
		}
		return false;
	}
}
