var input = arguments[0];
var output = arguments[1];
var opts = new ExportOptionsSaveForWeb();
opts.format = SaveDocumentType.PNG;
opts.PNG8 = false;
opts.quality = 100;

// magic start
var psd = open(File(input));
var clippedLayers = false;

mergeClippedLayers(psd);	// merge all clipped layers
mergeGroups(psd);			// merge all mergeable group
toggle(psd, false);			// hide them all
exportLayers(psd, "");		// export one by one

psd.close(SaveOptions.DONOTSAVECHANGES);
// magic end


function mergeClippedLayers(psdOrLayer) {
	if(isGroup(psdOrLayer)) {
		for (var i = 0; i < psdOrLayer.layers.length; i++) {
			mergeClippedLayers(psdOrLayer.layers[i]);
		}
	}
	
	if(psdOrLayer.grouped) {
		clippedLayers = clippedLayers ? clippedLayers : new Array();
		clippedLayers.push(psdOrLayer);
	} else {
		if(clippedLayers) {
			clippedLayers.push(psdOrLayer);
			
			var temp = psd.layerSets.add();
			temp.move(psdOrLayer, ElementPlacement.PLACEAFTER);
			for(var i = clippedLayers.length - 1; i >= 0; i--) {
				var groupedLayer = clippedLayers[i];
				groupedLayer.move(temp, ElementPlacement.INSIDE);
				if(i != clippedLayers.length - 1) {
					groupedLayer.grouped = true;
				}
			}
			temp.merge();
			
			clippedLayers = false;
			
			mergeClippedLayers(psd);
		}
	}
}

function mergeGroups(psdOrLayer) {
	if(isGroup(psdOrLayer)) {
		for (var i = 0; i < psdOrLayer.layers.length; i++) {
			mergeGroups(psdOrLayer.layers[i]);
		}
	}
	
	if(isMergeable(psdOrLayer)) {
		toggle(psdOrLayer, true);
		try { psdOrLayer.merge(); } catch (e) {}
	}
}


function toggle(psdOrLayer, visible) {
	if(isGroup(psdOrLayer)) {
		for (var i = 0; i < psdOrLayer.layers.length; i++) {
			toggle(psdOrLayer.layers[i], visible);
		}
	}
	
	psdOrLayer.visible = visible ? 1 : 0;
}

function exportLayers(psdOrLayer, index) {
	for (var i = 0; i < psdOrLayer.layers.length; i++) {
		var layer = psdOrLayer.layers[i];
		
		if(isGroup(layer)) {
			toggle(layer, false);
			layer.visible = 1;
			exportLayers(layer, index + "" + i);
		} else {
			toggle(layer, true);
			var img = output + index + "" + i;
			//if(isTrimmable(psd)) {
				psd.trim(TrimType.TRANSPARENT);
			//}
			psd.exportDocument(new File(img), ExportType.SAVEFORWEB, opts);
			psd.activeHistoryState = psd.historyStates[psd.historyStates.length - 2];
			new File(img + ".html").remove();	
		}
		
		toggle(layer, false);
	}
}



function isGroup(layer) {
	return (layer && layer.layers && layer.layers.length > 0);
}

function isMergeable(layer) {
	return (layer.name.indexOf("*") >= 0);
}

function isTrimmable(psd) {
    var res = true;
    var rArray = psd.channels["Red"].histogram.toString().replace(/0,|,0/g,"").split(',');
    var gArray = psd.channels["Green"].histogram.toString().replace(/0,|,0/g,"").split(',');
    var bArray = psd.channels["Blue"].histogram.toString().replace(/0,|,0/g,"").split(',');
    if(rArray.length == 1 && gArray.length == 1 && bArray.length == 1 ){
        res = false;
    }
    if(rArray.length == 0 && gArray.length == 0 && bArray.length == 0 ){
        res = false;
    }
    return res;
};