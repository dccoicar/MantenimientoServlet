package com.phantom.model;

import com.phantom.entity.Persona;
import com.phantom.service.ICrudDao;
import com.phantom.util.Constante;

public class PersonaDaoMemory implements ICrudDao<Persona> {
	
	

	Persona[] lista;
	static int autoID=0;
	static int nArray  = 0;
	
	
	public PersonaDaoMemory() {
		
		lista = new Persona[Constante.MAXIMO];		
	} 
	
	
	
	//Metodo para la persistencia de datos en memoria
	@Override
	public void create(Persona o) {
		
		
		try {
			autoID++;
			o.setId(autoID);
			lista[nArray] = o;
			
			System.out.println(lista[nArray].getApellidos());
			
			nArray++;	
			
		}catch (Exception e) {
			System.out.println("Falló guardando");
			System.out.println(e);
			
		}		
		
		
		
		
	}

	@Override
	public void update(Persona o) {
		
		for (int i = 0; i < nArray; i++) {
            if (lista[i].getId() == o.getId()) {
                lista[i] = o;
                break;
            }
        }		
		
	}
	
	
	

	@Override
	public void delete(Persona o) {
		
		for (int i = 0; i < nArray; i++) {
            if (lista[i].getId() == o.getId()) {
                for (int j = i; j < nArray; j++) {
                    lista[j] = lista[j + 1];  //
                }
                nArray--;
                break;
            }
        }		
	}

	@Override
	public Persona findFordId(int o) {
		
		for (int i = 0; i < nArray; i++) {
            if (lista[i].getId() == o) {
               return lista[i];
            }
        }

		return null;
	}

	@Override
	public Persona[] readAll() {
		
		Persona[] temp;
        if (nArray==Constante.MAXIMO) {
            temp=lista;
        }else{
          temp=new Persona[nArray];
          System.arraycopy(lista, 0, temp, 0, nArray);
        }
     		
		return temp;
	}
		
		

}
