﻿<!DOCTYPE helpset PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 1.0//EN"
"http://java.sun.com/products/javahelp/helpset_1_0.dtd">
<helpset>
	<title>Ayuda del Ahorcado</title>
	<maps>
		<homeID>introduccion</homeID>
		<mapref location="mi_map.jhm"/>
	</maps>
	
	<view>
		<name>Tabla de Contenidos</name>
		<label>Tabla de Contenidos</label>
		<type>javax.help.TOCView</type>
		<data>TOC.xml</data>
	</view>
	
	<view>
		<name>Indice</name>
		<label>El Indice</label>
		<type>javax.help.IndexView</type>
		<data>mi_index.xml</data>
	</view>	

	<view>
		<name>Buscar</name>
		<label>Buscar</label>
		<type>javax.help.SearchView</type>
        <data engine="com.sun.java.help.search.DefaultSearchEngine">
         JavaHelpSearch
        </data>
	</view>	
	
	<view>
		<name>Favoritos</name>
		<label>Favoritos</label>
		<type>javax.help.FavoritesView</type>
	</view>	
	
	<!-- Definición de la ventana principal de la ayuda-->  
    <presentation default="true" displayviews="true" displayviewimages="true">  
        <name>MainWin</name>  
            <!-- Dimensiones iniciales -->  
            <size width="800" height="480" /> 
			
            <!-- Posición inicial -->  
            <location x="200" y="200" /> 
			
            <!-- Título de la ventana -->  
            <title>Ayuda del programa InfoRed</title>  
            <!-- Definimos la barra de herramientas de la ventana -->  
            <toolbar>        
					<!-- Permitimos ir a la página anterior -->  
                    <helpaction image="BackwardIco">  
                            javax.help.BackAction  
                    </helpaction>  
					
                    <!-- Permitimos ir a la página siguiente -->  
                    <helpaction image="ForwardIco">  
                            javax.help.ForwardAction  
                    </helpaction>  
					
					<helpaction>  
                            javax.help.SeparatorAction 
                    </helpaction> 
					
                    <!-- Permitimos imprimir el contenido -->  
                    <helpaction image="PrintIco">  
                            javax.help.PrintAction  
                    </helpaction>  
					
                    <!-- Permitimos configurar la impresión -->  
                    <helpaction image="PrintSetupIco">  
                            javax.help.PrintSetupAction  
                    </helpaction>  
					
					<helpaction>  
                            javax.help.SeparatorAction 
                    </helpaction> 

					<helpaction>  
                            javax.help.HomeAction	
                    </helpaction> 
				
					
             </toolbar>  
    </presentation>
	
	<!-- configuramos la ventana secundaria -->
	<presentation displayviews=false>
		<name>secundaria</name>
		<size width="200" height="200" />
		<location x="200" y="200" />
	</presentation>

	<!-- configuramos la ventana popup-->
	<presentation displayviews=false>
		<name>popup</name>
		<location x="100" y="500" />
	<size width="200" height="500" />
	
</helpset>