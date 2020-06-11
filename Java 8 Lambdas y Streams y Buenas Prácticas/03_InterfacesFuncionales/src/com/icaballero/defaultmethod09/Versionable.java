package com.icaballero.defaultmethod09;

public interface Versionable<T extends Versionable<T>> {

	int getVersion();

/*	static <T extends Versionable<T>> T esMayor(T actual, T siguiente) {
		
	if(actual.getVersion() > siguiente.getVersion()) {
			
			return actual;
		}else {
			return siguiente;
		}
		
	}
*/
	
	default T esMayor(T t1) {
		
	if(this.getVersion() > t1.getVersion()) {
			
			return (T) this;
		}else {
			return t1;
		}
		
	}
}