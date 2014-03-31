package com.psdparser.model.layer.additional;

import java.util.List;

import com.psdparser.model.layer.AdditionalLayer;

public class EffectsLayer extends AdditionalLayer {

	private List<EffectLayer> effectLayers;
	
	public List<EffectLayer> getEffectLayers() {
		return effectLayers;
	}
	public void setEffectLayers(List<EffectLayer> effectLayers) {
		this.effectLayers = effectLayers;
	}
	
}
