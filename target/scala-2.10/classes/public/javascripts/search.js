function loadTypeahead(type) {
	console.log(type);
	var isLoad = false;
	if(type=="movies"){
		if(sessvars.movies.length==0){
			getDataByAjax("/Movies", type);
		} else {
			isLoad = true;
			sessvars.data = sessvars.movies;
		}
	} else if(type=="upcMovies"){
		if(null == sessvars.upcMovies || sessvars.upcMovies.length==0){
			getDataByAjax("/view/listUpCmng", type);
		} else {
			isLoad = true;
			sessvars.data = sessvars.upcMovies;
		}
	}
	if(isLoad){
		loadConsole(type);
	}
}

function getDataByAjax(url, type){
	if(type=="upcMovies"){
		$.ajax({
			url: url,
			type: 'GET',
			crossDomain: true,
			success: function(data){
				console.log("Successfully fetched data...");
				console.log(data);
				sessvars.data = getProcessedRTData(data);
				sessvars.upcMovies = sessvars.data;
				loadConsole(type);
				$('#loader_id').hide();
			},
			error: function(data){
				console.log("Error on fetching data....");
				console.log(data);
				$('#loader_id').hide();
			}
		});
	}else{
		$.ajax({
			url: url,
			headers: {"Accept":"application/json", "Apikey":sessvars.apiKeyNielsen},
			type: 'GET',
			crossDomain: true,
			success: function(data){
				console.log("Successfully fetched data...");
				console.log(data);
				sessvars.data = getProcessedData(data);
				if(type=="movies"){
					sessvars.movies = sessvars.data;
				} 
				loadConsole(type);
				$('#loader_id').hide();
			},
			error: function(data){
				console.log("Error on fetching data....");
				console.log(data);
				$('#loader_id').hide();
			}
		});
	}
	
}

function loadConsole(type){
	console.log('66');
	console.log(sessvars.data);
	console.log('hh');
	console.log(type);
	$('.'+type).typeahead({
		name: type,
		valueKey: 'Name',
		local: sessvars.data,
		template: ['<p class="repo-language">{{SubCategoryName}}</p>','<p class="repo-description">{{Name}}</p>','<p class="repo-name">{{Rank}}</p>'].join(''),
		engine: Hogan
	}).bind("typeahead:selected", function (obj, datum) {
		$('#loader_id').show();
		if(null!=datum){
			console.log(datum);
			var category = datum.subCategory;
			var movie = datum.Name;
			var rank = datum.Rank.replace('Rank: ','');
			if(datum.id){
				rank = datum.id;
			}
			document.location.href='/view/'+type+'?q='+movie+'&r='+rank+'&c='+category;
		}
	});
	$('#loader_id').hide();
}

function getProcessedData(data){
	var datum = [];
	var loadedData = data.Category[0].SubCategory;
	for(var ind = 0; ind < loadedData.length ; ind ++){
		var subCategoryName = loadedData[ind].SubCategoryName;
		var subCatList = loadedData[ind].Demographies[0].Items;
		for(var nxt = 0; nxt < subCatList.length; nxt ++){
			datum.push({
				SubCategoryName : "Category: "+subCategoryName+", Release Year: "+subCatList[nxt].ReleaseYear +", Distributor: "+ subCatList[nxt].Distributor,
				Name : subCatList[nxt].Name,
				Rank : "Rank: "+ subCatList[nxt].Rank,
				subCategory : subCategoryName
			});
		}
	}
	return datum;
}

function getProcessedRTData(data){
	var datum = [];
	data = data.movies;
	for(var ind = 0; ind < data.length ; ind ++){
		datum.push({
			SubCategoryName : "Release Date: "+data[ind].release_dates.theater+", Release Year: "+data[ind].year ,
			Name : data[ind].title,
			Rank : "Rank: NA",
			id: data[ind].id
		});

	}
	return datum;
}

$.ajaxPrefilter(function( options, originalOptions, jqXHR ) {
	console.log(options.headers);
	if(options.headers){
		options.url = "https://nielsen.api.tibco.com:443/TopTen/v1" + options.url;
	}else{
		
	}
});