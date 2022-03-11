SELECT
    o.NI_Num_Orden_Produccion, o.NI_Descripcion_2, o.NI_Data_Prevista_Original, o.NI_Hora_Prevista_Original, o.NI_Ample_Bobina, o.Terminada_Navision, o.UI_Estado_CP, o.NM_Repas_Informacio, o.NumComandes, o.Signada, o.NI_Data_Prevista_Cobertes, o.NI_Hora_Prevista_Cobertes,
    r.UI_Estado,
    l.NI_Num_Orden_Produccion, l.NI_Identificador_Tiratge, l.NI_Cantidad, l.NI_No_Planes_Totals_Tiratge, l.NI_Format_Tiratge, l.NI_Plegat_Tiratge, l.NI_Nom_Maquina, l.NI_Codi_Grup_Producto, l.Planificat, l.UI_Id_Lin_Ordre_P_Navision, l.DataEntregaManipuladorExtern , l.Planificat_Manipulat_Extern
FROM lin_ordre_p_navision l
    LEFT JOIN rutes_ordre_p_navision r ON l.UI_Id_Lin_Ordre_P_Navision = r.UI_Id_Lin_Ordre_P_Navision
    LEFT JOIN ordre_p_navision o ON o.NI_Num_Orden_Produccion = l.NI_Num_Orden_Produccion
where o.Terminada_Anna=0
order by o.NI_Num_Orden_Produccion;



SELECT 
    o.NI_Num_Orden_Produccion, o.NI_Descripcion_2, o.NI_Data_Prevista_Original, o.NI_Hora_Prevista_Original, o.NI_Ample_Bobina, o.Terminada_Navision, o.UI_Estado_CP, o.NM_Repas_Informacio, o.NumComandes, o.Signada, o.NI_Data_Prevista_Cobertes, o.NI_Hora_Prevista_Cobertes, 
    r.UI_Estado, 
    l.NI_Num_Orden_Produccion, l.NI_Identificador_Tiratge, l.NI_Cantidad, l.NI_No_Planes_Totals_Tiratge, l.NI_Format_Tiratge, l.NI_Plegat_Tiratge, l.NI_Nom_Maquina, l.NI_Codi_Grup_Producto, l.Planificat, l.UI_Id_Lin_Ordre_P_Navision, l.DataEntregaManipuladorExtern, l.Planificat_Manipulat_Extern
FROM lin_ordre_p_navision l 
    LEFT JOIN rutes_ordre_p_navision r ON l.UI_Id_Lin_Ordre_P_Navision = r.UI_Id_Lin_Ordre_P_Navision 
    LEFT JOIN ordre_p_navision o ON o.NI_Num_Orden_Produccion = l.NI_Num_Orden_Produccion
WHERE o.Terminada_Anna=0
ORDER BY o.NI_Num_Orden_ProduccionASC
