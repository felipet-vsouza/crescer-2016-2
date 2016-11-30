package br.com.cwi.crescer.exerc.aula5.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Filme.class)
public abstract class Filme_ {

	public static volatile SingularAttribute<Filme, Date> lancamento;
	public static volatile SingularAttribute<Filme, Elenco> elenco;
	public static volatile SingularAttribute<Filme, Genero> genero;
	public static volatile SingularAttribute<Filme, String> titulo;
	public static volatile SingularAttribute<Filme, Classificacao> classificacao;
	public static volatile SingularAttribute<Filme, Idioma> idioma;
	public static volatile SingularAttribute<Filme, Long> id;
	public static volatile SingularAttribute<Filme, String> diretor;

}

