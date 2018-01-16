/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	config.toolbar = [
		          		{ name: 'document', items: [ 'Source', '-', 'Save','Preview'] },
		        		{ name: 'editing', items: ['SelectAll'] },
		          		{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
		          		{ name: 'basicstyles', items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript'] },
		          		{ name: 'paragraph', items: [ 'NumberedList', 'BulletedList'] },
		          		{ name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'SpecialChar' ] },
		          		{ name: 'styles', items: [ 'Format', 'Font', 'FontSize' ] },
		          		'/',
		          		{ name: 'styles', items: [ 'Outdent', 'Indent', '-', 'JustifyLeft', 'JustifyCenter', 'JustifyBlock'] },
		          		{ name: 'tools', items: [ 'Maximize' ] }
		          	];
};
