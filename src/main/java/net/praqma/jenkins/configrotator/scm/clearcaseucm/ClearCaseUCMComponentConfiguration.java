package net.praqma.jenkins.configrotator.scm.clearcaseucm;

import java.io.Serializable;

import net.praqma.clearcase.exceptions.ClearCaseException;
import net.praqma.clearcase.ucm.entities.Baseline;
import net.praqma.clearcase.ucm.entities.Component;
import net.praqma.clearcase.ucm.entities.Project;
import net.praqma.clearcase.ucm.entities.Project.PromotionLevel;
import net.praqma.clearcase.ucm.entities.Stream;
import net.praqma.jenkins.configrotator.AbstractComponentConfiguration;

public class ClearCaseUCMComponentConfiguration extends AbstractComponentConfiguration {

	private static final long serialVersionUID = -1777151365163767788L;
	
	private Component component;
	private Stream stream;
	private Baseline baseline;
	private PromotionLevel plevel;
	
	public ClearCaseUCMComponentConfiguration( Component component, Stream stream, Baseline baseline, PromotionLevel plevel ) {
		this.component = component;
		this.stream = stream;
		this.baseline = baseline;
		this.plevel = plevel;
	}
	
	public ClearCaseUCMComponentConfiguration( String component, String stream, String baseline, String plevel ) throws ClearCaseException {
		this.component = Component.get( component, false );
		this.stream = Stream.get( stream, false );
		this.baseline = Baseline.get( baseline, false );
		this.plevel = Project.PromotionLevel.valueOf( plevel );
	}

	public Component getComponent() {
		return component;
	}

	public Stream getStream() {
		return stream;
	}

	public Baseline getBaseline() {
		return baseline;
	}
	
	public PromotionLevel getPlevel() {
		return plevel;
	}
}
